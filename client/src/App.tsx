import { BrowserRouter, Route, Routes } from "react-router"
import * as routes from "./routes"
import HomePage from "./pages/HomePage"
import Header from "./components/HeaderFooter"
import UploadPage from "./pages/UploadPage"
function App() {

  return (
    <Header>
      <BrowserRouter>
        <Routes>
          <Route path={routes.HOME_PAGE_URL} element={<HomePage></HomePage>}></Route>
          <Route path={routes.UPLOAD_PAGE_URL} element={<UploadPage></UploadPage>}></Route>
        </Routes>
      </BrowserRouter>
    </Header>
  )
}

export default App
