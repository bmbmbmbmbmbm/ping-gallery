import { Box, Button, Stack, TextField, Typography } from "@mui/material"
import useImageUploadForm from "../hooks/useImageUploadForm"
import ChooseImage from "../components/ChooseImage"

function UploadPage() {
    const form = useImageUploadForm()

    return (
        <Box component="form" onSubmit={form.handleSubmit} mt="20px">
            <Stack spacing={2} alignItems="baseline">
                <Typography variant="h4">Image Upload</Typography>
                <TextField
                    id="name"
                    name="name"
                    label="Image Name/Title"
                    onChange={form.handleChange}
                    onBlur={form.handleBlur}
                    error={form.touched.name && Boolean(form.errors.name)}
                    helperText={form.touched.name && form.errors.name}
                ></TextField>
                <ChooseImage
                    data={form.values} 
                    errors={form.errors} 
                    touched={form.touched} 
                    setFieldValue={form.setFieldValue}
                    onBlur={form.handleBlur}                                     
                ></ChooseImage>
                <Button variant="contained" type="submit">Submit</Button>
            </Stack>
        </Box>
    )
}

export default UploadPage