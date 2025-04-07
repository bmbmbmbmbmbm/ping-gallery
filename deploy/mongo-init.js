db.createUser(
    {
        user: "gallery",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "gallery-database"
            }
        ]
    }
);