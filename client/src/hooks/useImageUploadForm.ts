import axios from "axios";
import { FormikErrors, useFormik } from "formik";
import { IMAGE_FILE_URL } from "../api";
import { useNavigate } from "react-router";
import { HOME_PAGE_URL } from "../routes";

function useImageUploadForm() {
    const navigate = useNavigate()

    const initialValues: ImageUpload = {
        name: "",
        file: null
    }

    const validateOnBlur = true
    const validateOnChange = true

    const onSubmit = async (values: ImageUpload) => {
        if (values.file) try {
            const formData = new FormData()
            formData.set("name", values.name)
            formData.set("file", values.file)
            const res = await axios.post(IMAGE_FILE_URL, formData)
            if ("id" in res.data) {
                navigate(HOME_PAGE_URL)
            }
        } catch (e) {
            console.error(e)
        }
    }

    const validate = (values: ImageUpload) => {
        const errors: FormikErrors<ImageUpload> = {}
        if (!values.name) {
            errors.name = "Required"
        }
        if (!values.file) {
            errors.file = "Required"
        }
        return errors
    }

    const form = useFormik({initialValues, onSubmit, validate, validateOnBlur, validateOnChange})
    
    return form
}

export default useImageUploadForm