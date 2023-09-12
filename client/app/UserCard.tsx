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
      <h4 className="user-card__id user-card__field">User ID: {props.id}</h4>
      <h3 className="user-card__name user-card__field">Name: {props.firstname} {props.lastname}</h3>
      {props.palindrome ? <p className="user-card__palindrome user-card__field">This user's first name is a palindrome</p> : ""}
      <p className="user-card__age user-card__field">Age: {props.age}</p>
      <h5 className="user-card__username user-card__field">Username: {props.username}</h5>
    </div>
  )
}

export default UserCard