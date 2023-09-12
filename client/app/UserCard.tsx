export type User = {
  id: string,
  firstname: string,
  palindrome?: string,
  lastname: string,
  username: string,
  age: string,
}

function UserCard(props: User) {



  return (
    <div className="user-card">
      <h4 className="user-card__id">User Id: {props.id}</h4>
      <h3 className="user-card__name">Name: {props.firstname} {props.lastname}</h3>
      {props.palindrome ? <p className="user-card__palindrome">This user's first name is a palindrome</p> : ""}
      <p className="user-card__age">Age: {props.age}</p>
      <h5 className="user-card__username">Username: {props.username}</h5>
    </div>
  )
}

export default UserCard