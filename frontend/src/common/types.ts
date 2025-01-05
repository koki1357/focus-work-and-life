export interface Book {
  id: number;
  title: string;
  image: string;
  author: string;
  startDate: string;
  finishDate: string;
  daysPerWeek: number;
}

export interface ApiError {
  response: {
    data: {
      message: string;
    };
  };
}

export interface ApiResponse<T> {
  data: T;
}
