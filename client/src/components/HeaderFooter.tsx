import { AppBar, Box, Button, Container, Toolbar } from "@mui/material"
import { ReactNode } from "react"
import * as routes from "../routes"
interface HeaderProps {
    children: ReactNode
}

function Header({ children }: HeaderProps) {
    return (
        <>
            <Box sx={{ flexGrow: 1 }}>
                <AppBar position="sticky">
                    <Toolbar>
                        <Button color="inherit" href={routes.HOME_PAGE_URL}>Gallery</Button>
                        <Button color="inherit" href={routes.UPLOAD_PAGE_URL}>Upload Image</Button>
                    </Toolbar>
                </AppBar>
            </Box>
            <Container>
                {children}
            </Container>
        </>
    )
}

export default Header