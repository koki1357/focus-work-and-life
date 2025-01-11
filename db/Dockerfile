FROM mysql:8.0

# ポートの設定
EXPOSE 3306

# MySQL設定ファイルをコピー
COPY ./my.cnf /etc/mysql/conf.d/my.cnf

# コンテナ内の/docker-entrypoint-initdb.d/配下にDB初期化用のSQLファイルを配置する。/docker-entrypoint-initdb.d/配下のSQLファイルはファイル名の昇順で実行される
COPY ./initdb.d/1_schema.sql /docker-entrypoint-initdb.d/1_schema.sql
COPY ./initdb.d/init.sql/2_testdata.sql /docker-entrypoint-initdb.d/2_testdata.sql

CMD ["mysqld"]