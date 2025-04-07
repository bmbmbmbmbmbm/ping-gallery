import { Box, Stack } from "@mui/material"
import { FormikErrors, FormikTouched } from "formik"
import React from "react"
import { sizeFormat } from "../utils/file"

interface ChooseImageProps {
    data: ImageUpload,
    errors: FormikErrors<ImageUpload>
    touched: FormikTouched<ImageUpload>
    setFieldValue: (field: string, value: any, shouldValidate?: boolean) => Promise<void> | Promise<FormikErrors<ImageUpload>>
    onBlur: {
        (e: React.FocusEvent<any, Element>): void;
        <T = any>(fieldOrEvent: T): T extends string ? (e: any) => void : void;
    }
}
/**
 * Used to upload image files into a Formik form. Modified a file upload component from below.
 * Sourced from https://uploadcare.com/blog/how-to-upload-file-in-react/
 */
function ChooseImage({ data, errors, touched, setFieldValue, onBlur }: ChooseImageProps) {

    const handleFileChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        if (e.target.files) {
            setFieldValue("file", e.target.files[0])
        }
    }

    return (
        <Box id="choose-image">
            <Stack>
                <input id="file" type="file" accept=".png,.jpg,.jpeg" onChange={handleFileChange} onBlur={onBlur} required />
                {touched.file && Boolean(errors.file) &&
                    <label>{errors.file}</label>
                }
            </Stack>
            {data.file && (
                <Box component="section">
                    File details:
                    <ul>
                        <li>Name: {data.file.name}</li>
                        <li>Type: {data.file.type}</li>
                        <li>Size: {sizeFormat(data.file.size)}</li>
                    </ul>
                </Box>
            )}
        </Box>
    )
}

export default ChooseImage