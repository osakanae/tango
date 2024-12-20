ユースケース定義
* 代替フロー テンプレート
  - **フロー1（ネットワークエラー）**  
    - システムが〇〇中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」
    - システムは「再試行」ボタンと「キャンセル」ボタンを表示する。
      - **ユーザーが「再試行」ボタンをクリックした場合**  
        - システムはネットワーク接続を再確認し、直前に表示していた動作をする。
        - 再試行が成功した場合、テストは続行され、正常フローに戻る。
        - 再試行が失敗した場合、再度エラーメッセージを表示し、再試行またはキャンセルの選択を促す。
      - **ユーザーが「キャンセル」ボタンをクリックした場合**  
        - システムはテストを中断し、ユーザーを〇〇に戻す。

UC01:アカウント登録
* 概要
新しいユーザーがTangoに登録し、ログイン可能なアカウントを作る際のプロセス
* 前提条件
・ユーザーはアカウントを持っていない
・ユーザーがアプリケーションの「アカウント登録」ページにアクセスできる
* 事後条件
・ユーザーのアカウントが作成され、ログインできる状態である
・「登録完了」メッセージが表示されている
* 正常フロー
1. ユーザーが「アカウント登録」ページにアクセスする
2. ユーザーが以下の情報を入力する
    - ユーザー名
    - メールアドレス
    - パスワード
3. ユーザーが「登録」ボタンをクリックする
4. システムは入力内容をバリデーションし、問題がなければ新しいアカウントを作成する
5. 「登録完了」メッセージが表示され、ログインページに遷移するか、自動ログインを行う
* 代替フロー
- フロー1（入力のバリデーション失敗）
入力されたユーザー名、メールアドレス、またはパスワードが無効（例：既に登録済みのメールアドレス、パスワードの要件を満たしていない）である場合、システムはエラーメッセージを表示する。
ユーザーは入力内容を修正し、再度「登録」ボタンをクリックする。
- フロー2（ネットワークエラー）
システムが登録処理中にネットワークエラーが発生した場合、エラーメッセージを表示し、再試行を促す。
*  例外処理
システムエラーが発生した場合、システムは「現在アカウント登録ができません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。
* ビジネスルール
・ユーザー名とメールアドレスはシステム内で一意である必要がある。
・パスワードは8文字以上、かつ英数字を含む必要がある。

UC02:ログイン
* 概要
ユーザーがアプリケーションにログインする際のプロセス。
* 前提条件
・ユーザーがログアウト状態である
・ユーザーがアプリケーションのログイン画面にアクセスできる
* 事後条件
・ユーザーがログイン状態であり、トップページに遷移している
* 正常フロー
1. ユーザーがログインページにアクセスする
2. ユーザーが以下の情報をシステムに入力する
3. メールアドレス
4. パスワード
5. ユーザーがログインボタンを押す
6. システムは入力データをバリデーションし、問題がなければユーザーをログイン状態にする
7. トップページへ遷移する
* 代替フロー
- フロー1（入力のバリデーション失敗）
1. システムは入力されたメールアドレス、またはパスワードが無効である場合、エラーメッセージを表示する。
2. ユーザーは入力内容を修正し、再度「ログイン」ボタンをクリックする。
- フロー2（ネットワークエラー）
システムがログイン処理中にネットワークエラーが発生した場合、エラーメッセージを表示し、再試行を促す。
*  例外処理
システムエラーが発生した場合、システムは「現在ログインできません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC03：ログアウト
* 概要
ユーザーがシステムからログアウトする際のプロセス
* 前提条件
・ユーザーがシステムにログインしている
* 事後条件
・ユーザーがシステムからログアウトしており、ログイン画面に遷移している
* 正常フロー
1. ユーザーがログアウトボタンをクリックする
2. システムは「ログアウトしますか？はい　キャンセル」という確認メッセージウインドウを出す
3. ユーザーが「はい」を選択する
4. システムはユーザーをシステムからログアウトし、ログイン画面に遷移する
* 代替フロー
- フロー1
システムがログアウト処理中にネットワークエラーが発生した場合、エラーメッセージを表示し、再試行を促す。ユーザーは「再試行」ボタンをクリックして再度ログアウトを試みることができる。 
* 例外処理
システムエラーが発生した場合、システムは「現在ログアウトできません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC04：単語帳作成
概要
ユーザーが単語帳を新規作成する際のプロセス
前提条件
・ユーザーがシステムにログインしている
事後条件
・システムに単語帳が登録され、「単語帳」メニューに表示されている
正常フロー
ユーザーが「単語帳」メニューの「＋」ボタンを押す
ユーザーは単語帳の名前を入力し、「決定」ボタンを押す
システムは入力データのバリデーションを行い、問題がなければ新しい単語帳を登録する
登録が完了すると、「単語帳」メニューの配下に登録した単語帳が表示される
代替フロー
フロー1
システムが単語帳作成処理中にネットワークエラーが発生した場合、エラーメッセージを表示し、再試行を促す。ユーザーは「再試行」ボタンをクリックして再度単語帳作成を試みることができる。 
例外処理
システムエラーが発生した場合、システムは「現在単語帳作成ができません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC05：単語登録
* 概要
ユーザーが単語とその定義を新規登録する際のプロセス
* 前提条件
・ユーザーがシステムにログインしている
・ユーザーが単語登録ページにアクセスできる
* 事後条件
・システムに単語とその定義が登録され、選択した単語帳に追加されている
・選択した単語帳がそのまま表示されており、ユーザーが続けて単語を登録できる
* 正常フロー
1. ユーザーが各単語帳ページから単語登録ページにアクセスする
2. ユーザーは単語とその定義を入力する
3. ユーザーが登録ボタンを押す
4. システムは入力データのバリデーションを行い、問題がなければ単語とその定義が登録する
5. 登録が完了すると、システムは単語登録ページにリダイレクトし、続けて単語を登録できるようにする
* 代替フロー
- フロー1
システムが単語登録中にネットワークエラーが発生した場合、エラーメッセージを表示し、再試行を促す。ユーザーは「再試行」ボタンをクリックして再度単語登録を試みることができる。 
* 例外処理
システムエラーが発生した場合、システムは「現在単語登録ができません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。
* ビジネスルール
・単語は300字まで、定義は1500文字まで入力できる。

UC06：単語編集
* 概要
ユーザーが登録済の単語とその定義を編集する際のプロセス
* 前提条件
・ユーザーがシステムにログインしている
・ユーザーが単語一覧ページにアクセスできる
・単語が一つ以上登録されている
* 事後条件
・単語の新しい内容が登録され、ユーザーに反映されている
* 正常フロー
1. ユーザーが各単語帳ページから単語一覧ページにアクセスする
2. ユーザーが編集したい単語の横の「編集」ボタンを押す
3. システムは単語の編集ウィンドウを表示する
4. ユーザーは単語や定義を編集し、「完了」ボタンを押す
5. システムは編集内容を登録し、編集ウィンドウを閉じて変更を反映する
* 代替フロー
- フロー1
システムが単語編集中にネットワークエラーが発生した場合、エラーメッセージを表示し、再試行を促す。ユーザーは「再試行」ボタンをクリックして再度単語編集を試みることができる。 
* 例外処理
システムエラーが発生した場合、システムは「現在単語編集ができません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC07：単語の削除
* 概要
ユーザーが登録済の単語を削除する際のプロセス
* 前提条件
・ユーザーがシステムにログインしている
・ユーザーが単語一覧ページにアクセスできる
・単語が一つ以上登録されている
* 事後条件
・選択した単語が削除され、一覧から非表示になっている
* 正常フロー
1. ユーザーが各単語帳ページから単語一覧ページにアクセスする
2. ユーザーが削除したい単語の横の「削除」ボタンを押す
3. システムは「削除してよろしいですか？」という確認ウィンドウを表示する
4. ユーザーが「はい」を選択する
5. システムは単語を削除し、確認ウィンドウを閉じて削除が一覧に反映される
* 代替フロー  
  - フロー1（ネットワークエラー）
    - システムが単語削除処理中にネットワークエラーが発生した場合、エラーメッセージを表示し、再試行を促す。ユーザーは「再試行」ボタンをクリックして再度単語削除を試みることができる。  
* 例外処理  
  システムエラーが発生した場合、システムは「現在単語削除ができません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC08：単語テスト
* 概要
ユーザーが登録済の単語で暗記テストをする際のプロセス
* 前提条件
・単語が一つ以上登録されている単語帳が一つ以上登録されている
・ユーザーが単語テストページにアクセスできる
* 事後条件
・ユーザーが暗記テストの結果（暗記済フラグ）を保存できている  
* 正常フロー
1. ユーザーが各単語帳ページのから「テスト」ページへアクセスする
2. ユーザーは「全て・未暗記・部分記憶・暗記済」の中から表示する単語の範囲を選択し、「定義を隠す・単語を隠す」のいずれかを選択し、「テスト開始」ボタンを押す
3. システムは選択内容に基づき、定義または単語のどちらかが隠された状態で表示する
4. 開くボタンを押すと隠された内容が表示される
5. ユーザーは暗記度に応じてラジオボタンを選択する
6. システムはユーザーの暗記度を更新する
7. システムは次の単語を表示し、登録した単語がなくなるまで繰り返す
8. 全ての単語が終了する、または「テスト終了」ボタンを押すとテストが終了し、テスト完了メッセージを表示する
* 代替フロー  
- フロー1（ネットワークエラー）
    - システムが単語テスト中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」
    - システムは「再試行」ボタンと「キャンセル」ボタンを表示する。
        - ユーザーが「再試行」ボタンをクリックした場合**  
            - システムはネットワーク接続を再確認し、直前に表示していた単語からテストを再開する。
            - 再試行が成功した場合、テストは続行され、正常フローに戻る。
            - 再試行が失敗した場合、再度エラーメッセージを表示し、再試行またはキャンセルの選択を促す。
        - ユーザーが「キャンセル」ボタンをクリックした場合**  
            - システムはテストを中断し、ユーザーを単語テストページに戻す。  
* 例外処理  
  システムエラーが発生した場合、システムは「現在単語テストができません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC09：検索
* 概要
ユーザーが登録済の単語の中から条件に該当するものを検索する際のプロセス
* 前提条件
・特になし
* 事後条件
・該当する単語が検索され、検索結果がユーザーに表示されている	
* 正常フロー
1. ユーザーが検索ボックスに検索語を入力し、「検索」ボタンを押す
2. システムは単語・定義内に検索語が含まれる単語を検索する  
3. システムは該当する単語を単語帳名と共に表示する
* 代替フロー  
- フロー1（ネットワークエラー）
- システムが検索中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」
- システムは「再試行」ボタンと「キャンセル」ボタンを表示する。
    - ユーザーが「再試行」ボタンをクリックした場合
        - システムはネットワーク接続を再確認し、検索語が保持された状態で再度検索を試みる。
        - 再試行が成功した場合、検索結果が表示され、正常フローに戻る。
        - 再試行が失敗した場合、再度エラーメッセージを表示し、再試行またはキャンセルの選択を促す。
    - ユーザーが「キャンセル」ボタンをクリックした場合
        - システムは検索を中断し、検索結果を表示しない状態に戻る。
* 例外処理  
  システムエラーが発生した場合、システムは「現在検索ができません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。


UC10：暗記率表示
* 概要
ユーザーが単語帳ごとの暗記率を表示する際のプロセス
* 前提条件
・ユーザーが「暗記率」ページにアクセスできる
* 事後条件
・「暗記率」ページで各単語帳の暗記率が表示されており、ユーザーが現在の暗記状況を把握できる
* 正常フロー
1. ユーザーが「暗記率」ページにアクセスする
2. システムは各単語帳ごとの暗記率（暗記済フラグの数/全単語数）を計算する
3. システムは計算結果を各単語帳ごとに表示する
* 代替フロー  
- フロー1（ネットワークエラー）
    - システムが暗記率計算中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」
    - システムは「再試行」ボタンと「キャンセル」ボタンを表示する。
        - ユーザーが「再試行」ボタンをクリックした場合
            - システムはネットワーク接続を再確認し、再度計算を試みる。
            - 再試行が成功した場合、暗記率の計算結果が表示され、正常フローに戻る。
            - 再試行が失敗した場合、再度エラーメッセージを表示し、再試行またはキャンセルの選択を促す。
        - ユーザーが「キャンセル」ボタンをクリックした場合
            - システムは計算を中断し、元のページに戻る。
* 例外処理  
システムエラーが発生した場合、システムは「現在暗記率ページが表示できません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC11：単語帳削除
* 概要
ユーザーが単語帳の削除をする際のプロセス
* 前提条件
・単語帳が一つ以上登録されている
・ユーザーがシステムにログインしている
* 事後条件
・削除対象の単語帳が単語帳一覧から非表示になり、「削除済単語帳」ページに表示されている
・削除済単語帳は30日間「削除済単語帳」ページで確認できるが、その後完全に削除される
・30日経過後、削除済単語帳ページから単語帳が削除されている
* 正常フロー
1. ユーザーが削除対象単語帳名横の「削除」ボタンを押す
2. システムが「単語帳：〇〇を削除しますか？」と確認ウィンドウを出す
3. ユーザーが「はい」をクリックする
4. システムは単語帳一覧の削除対象単語帳を非表示にし、「削除済単語帳」ページに追加する
5. システムは「削除済単語帳」ページに30日間削除対象単語帳を表示する
6. 30日経過後、システムは削除済単語帳ページから削除対象単語帳を完全に削除する
* 代替フロー  
- フロー1（ネットワークエラー）
    - システムが単語帳削除中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」
    - システムは「再試行」ボタンと「キャンセル」ボタンを表示する。
        - ユーザーが「再試行」ボタンをクリックした場合
            - システムはネットワーク接続を再確認し、再度単語帳削除を試みる。
            - 再試行が成功した場合、単語帳削除が実行され、正常フローに戻る。
            - 再試行が失敗した場合、再度エラーメッセージを表示し、再試行またはキャンセルの選択を促す。
        - ユーザーが「キャンセル」ボタンをクリックした場合
            - システムは単語帳削除を中断し、元のページに戻る。
* 例外処理  
システムエラーが発生した場合、システムは「現在単語帳削除ができません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC12：削除済単語帳復活
* 概要
ユーザーが削除済単語帳ページの単語帳を単語帳一覧に戻す際のプロセス
* 前提条件
・ユーザーがシステムにログインしている
・ユーザーが削除済単語帳ページにアクセスできる
・削除済単語帳ページに一つ以上の単語帳が表示されている
* 事後条件
・削除済単語帳ページから復活対象単語帳が削除されている
・単語帳一覧に復活対象単語帳が表示され、ユーザーが確認できる
* 正常フロー
1. ユーザーが削除済単語帳ページにアクセスする
2. ユーザーが復活させたい単語帳名の横にある「元に戻す」ボタンをクリックする
3. システムは削除済単語帳ページから復活対象単語帳を非表示にする
4. システムは単語帳一覧に復活対象単語帳を表示し、ユーザーに確認可能な状態で提示する
* 代替フロー  
- フロー1（ネットワークエラー）
    - システムが単語帳復活中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」
    - システムは「再試行」ボタンと「キャンセル」ボタンを表示する。
        - ユーザーが「再試行」ボタンをクリックした場合
            - システムはネットワーク接続を再確認し、再度単語帳復活を試みる。
            - 再試行が成功した場合、単語帳復活が実行され、正常フローに戻る。
            - 再試行が失敗した場合、再度エラーメッセージを表示し、再試行またはキャンセルの選択を促す。
        - ユーザーが「キャンセル」ボタンをクリックした場合
            - システムは復活処理を中断し、ユーザーを元の削除済単語ページに戻す。
* 例外処理  
システムエラーが発生した場合、システムは「現在単語帳を元に戻すことができません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC13：単語帳インポート
* 概要
ユーザーが外部CSVファイルを単語帳にインポートする際のプロセス
* 前提条件
・ユーザーがシステムにログインしている
* 事後条件
・インポートされたCSVファイルの内容が単語帳に登録され、ユーザーが登録結果を確認できる 
* 正常フロー
1. ユーザーが各単語帳ページの「インポート」ボタンをクリックする
2. システムはファイル選択ウィンドウを開く
3. ユーザーはインポートしたいCSVファイルを選択し、決定ボタンをクリックする
4. システムは選択されたCSVファイルのフォーマットをバリデーションする
5. バリデーションが成功した場合、システムはCSVファイル内の単語と定義を単語帳に登録する
6. システムはインポート結果をユーザーに通知する（例：インポートされた単語数、エラーが発生した行数など）
* 代替フロー
- フロー1（ファイルフォーマットエラー）
    - CSVファイルのフォーマットが不正（例：列数が異なる、必須項目が欠落しているなど）の場合、システムはエラーメッセージを表示し、インポートを中断する。 
- フロー2（ネットワークエラー）
    - システムがCSVファイルのインポート中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」
    - システムは「再試行」ボタンと「キャンセル」ボタンを表示する。
        - ユーザーが「再試行」ボタンをクリックした場合**  
            - システムはネットワーク接続を再確認し、再度インポート処理を試みる。
            - 再試行が成功した場合、正常フローに戻り、CSVファイルのインポートが完了する。 
            - 再試行が失敗した場合、再度エラーメッセージを表示し、再試行またはキャンセルの選択を促す。
        - ユーザーが「キャンセル」ボタンをクリックした場合**  
            - システムはインポート処理を中断し、ユーザーを単語帳ページに戻す。  
* 例外処理  
システムエラーが発生した場合、システムは「現在CSVファイルをインポートできません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC14：単語帳エクスポート
* 概要
ユーザーが単語帳をCSVファイルとしてエクスポートする際のプロセス
* 前提条件
・ユーザーがログインしている
* 事後条件
・単語帳の内容がCSVファイルとしてダウンロードされ、ユーザーがダウンロード完了の通知を確認できる
* 正常フロー
1. ユーザーが単語帳ページの「エクスポート」ボタンをクリックする
2. システムはエクスポート対象の単語帳に内容があるかを確認する
3. 内容がある場合、システムは単語帳の内容をCSVファイルとして生成し、ユーザーのデバイスにダウンロードする
4. ダウンロードが完了したことを通知するメッセージをユーザーに表示する
* 代替フロー  
- フロー1（エクスポート対象が空の場合）
    - エクスポート対象の単語帳が空の場合、システムは「エクスポートする内容がありません」というエラーメッセージを表示し、エクスポートを中断する。  
- フロー2（ネットワークエラー）
    - システムがCSVファイルのダウンロード中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」  
    - システムは「再試行」ボタンと「キャンセル」ボタンを表示する。  
        - ユーザーが「再試行」ボタンをクリックした場合
            - システムはネットワーク接続を再確認し、再度ダウンロード処理を試みる。  
            - 再試行が成功した場合、正常フローに戻り、CSVファイルのダウンロードが完了する。  
            - 再試行が失敗した場合、エラーメッセージを再表示し、再試行またはキャンセルの選択を促す。  
    - ユーザーが「キャンセル」ボタンをクリックした場合
            - システムはダウンロード処理を中断し、ユーザーを単語帳ページに戻す。 
* 例外処理
システムエラーが発生した場合、システムは「現在単語帳をエクスポートできません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC15：お問い合わせ
* 概要
ユーザーがTangoアプリに関する要望・意見等フィードバックをフォームから送信する際のプロセス
* 前提条件
・ユーザーがお問い合わせページへアクセスできる
* 事後条件
・ユーザーが入力したフィードバックがサーバーへ送信され、送信完了の確認画面が表示されている 
* 正常フロー
1. ユーザーがお問い合わせページへアクセスする
2. ユーザーがお問い合わせ内容を入力する
3. システムはお問い合わせ内容のバリデーションを行う
4. バリデーションが成功した場合、システムはお問い合わせ内容を送信する
5. システムは「お問い合わせ完了」画面を表示する
* 代替フロー
- フロー1（ネットワークエラー）
    - システムがお問い合わせ内容送信中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」  
    - システムは「再試行」ボタンと「キャンセル」ボタンを表示する。  
        - ユーザーが「再試行」ボタンをクリックした場合 
            - システムはネットワーク接続を再確認し、入力内容を保持した状態で再度送信を試みる。  
            - 再試行が成功した場合、正常フローに戻り、お問い合わせ完了画面を表示する。 
            - 再試行が失敗した場合、エラーメッセージを再表示し、再試行またはキャンセルの選択を促す。  
        - ユーザーが「キャンセル」ボタンをクリックした場合
            - システムは送信を中断し、ユーザーを「お問い合わせ」画面へ戻す
*  例外処理
システムエラーが発生した場合、システムは「現在お問い合わせを送信できません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。

UC16：アカウント削除
* 概要
ユーザーがTangoアカウントを削除する際のプロセス
* 前提条件
・ユーザーがログインしている
* 事後条件
・該当ユーザーのアカウントが削除され、ユーザーが自動的にログアウトされてトップページに戻る  
* 正常フロー
1. ユーザーが「アカウント削除」ボタンを押す
2. システムは「アカウントを削除すると元には戻せません。本当に削除しますか？」という警告ウィンドウを表示し、ユーザーに「削除」と入力させるフィールドを表示する
3. ユーザーが「削除」と入力し、「削除する」ボタンをクリックする  
4. システムは該当ユーザーのアカウントを削除し、自動的にログアウトしてトップページに遷移する 
* 代替フロー
- フロー1（ネットワークエラー）
    - システムがアカウント削除中にネットワークエラーが発生した場合、以下のメッセージを表示する:「ネットワークエラーが発生しました。再試行しますか？」  
    - システムは「再試行」ボタンと「キャンセル」ボタンを表示する。  
        - ユーザーが「再試行」ボタンをクリックした場合 
            - システムはネットワーク接続を再確認し、再度削除を試みる。  
            - 再試行が成功した場合、正常フローに戻り、アカウントを削除する
            - 再試行が失敗した場合、エラーメッセージを再表示し、再試行またはキャンセルの選択を促す。  
        - ユーザーが「キャンセル」ボタンをクリックした場合
            - システムは削除操作を中断し、ユーザーをアカウント削除画面へ戻す
*  例外処理
システムエラーが発生した場合、システムは「現在アカウントを削除できません。しばらくしてから再度お試しください。」というエラーメッセージを表示する。





