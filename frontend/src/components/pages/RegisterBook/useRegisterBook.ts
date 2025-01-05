// frontend/src/hooks/useRegisterBook.ts
import { ApiError } from '@/common/types';
import { createHeader } from '@/common/util/api-util';
import { errorAtom } from '@/components/organisms/error-modal/ErrorModal';
import axios from 'axios';
import { useAtom } from 'jotai';
import { RegisterBookFormValues } from './RegisterBookPage';

type RegisterBookRequest = RegisterBookFormValues & { userId: string };

export const useRegisterBook = () => {
  const [, setErrorState] = useAtom(errorAtom);
  const registerBook = async (data: RegisterBookRequest) => {
    try {
      console.log(data);
      const response = await axios.post('http://localhost:8080/api/v1/books/register', data, {
        headers: createHeader(),
      });
      return response.data;
    } catch (error: unknown) {
      const apiError = error as ApiError;
      setErrorState({
        hasError: true,
        messages: [apiError.response.data.message],
      });
      throw apiError;
    }
  };

  return { registerBook };
};
