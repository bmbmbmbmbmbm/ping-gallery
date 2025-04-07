import { BrowserRouter, Route, Routes } from "react-router"
import * as routes from "./routes"
import HomePage from "./pages/HomePage"
function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path={routes.HOME_PAGE_URL} element={<HomePage></HomePage>}></Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
