import { useEffect, useState } from "react"
import axios from "axios"
import { IMAGE_METADATA_URL } from "../api"

function useImageMetaList() {
    const [imageMetaList, setMetaList] = useState<ImageMeta[]>([])

    const getImageMetaList = async () => {
        try {
            const res = await axios.get<ImageMeta[]>(IMAGE_METADATA_URL)
            if (res.data) {
                setMetaList(res.data)
            }
        } catch (e) {
            console.error(e)
        }
    }

    useEffect(() => {
        getImageMetaList()
    }, [])

    return imageMetaList
}

export default useImageMetaList