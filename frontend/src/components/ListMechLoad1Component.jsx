import React, { Component } from 'react'
import MechLoad1Service from '../services/MechLoad1Service'

class ListMechLoad1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                mechLoad1s: []
        }
        this.addMechLoad1 = this.addMechLoad1.bind(this);
        this.editMechLoad1 = this.editMechLoad1.bind(this);
        this.deleteMechLoad1 = this.deleteMechLoad1.bind(this);
    }

    deleteMechLoad1(id){
        MechLoad1Service.deleteMechLoad1(id).then( res => {
            this.setState({mechLoad1s: this.state.mechLoad1s.filter(mechLoad1 => mechLoad1.mechLoad1Id !== id)});
        });
    }
    viewMechLoad1(id){
        this.props.history.push(`/view-mechLoad1/${id}`);
    }
    editMechLoad1(id){
        this.props.history.push(`/add-mechLoad1/${id}`);
    }

    componentDidMount(){
        MechLoad1Service.getMechLoad1s().then((res) => {
            this.setState({ mechLoad1s: res.data});
        });
    }

    addMechLoad1(){
        this.props.history.push('/add-mechLoad1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">MechLoad1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addMechLoad1}> Add MechLoad1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> A </th>
                                    <th> B </th>
                                    <th> D </th>
                                    <th> E </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.mechLoad1s.map(
                                        mechLoad1 => 
                                        <tr key = {mechLoad1.mechLoad1Id}>
                                             <td> { mechLoad1.a } </td>
                                             <td> { mechLoad1.b } </td>
                                             <td> { mechLoad1.d } </td>
                                             <td> { mechLoad1.e } </td>
                                             <td>
                                                 <button onClick={ () => this.editMechLoad1(mechLoad1.mechLoad1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteMechLoad1(mechLoad1.mechLoad1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewMechLoad1(mechLoad1.mechLoad1Id)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListMechLoad1Component
