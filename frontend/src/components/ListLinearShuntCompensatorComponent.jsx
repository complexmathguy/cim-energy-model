import React, { Component } from 'react'
import LinearShuntCompensatorService from '../services/LinearShuntCompensatorService'

class ListLinearShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                linearShuntCompensators: []
        }
        this.addLinearShuntCompensator = this.addLinearShuntCompensator.bind(this);
        this.editLinearShuntCompensator = this.editLinearShuntCompensator.bind(this);
        this.deleteLinearShuntCompensator = this.deleteLinearShuntCompensator.bind(this);
    }

    deleteLinearShuntCompensator(id){
        LinearShuntCompensatorService.deleteLinearShuntCompensator(id).then( res => {
            this.setState({linearShuntCompensators: this.state.linearShuntCompensators.filter(linearShuntCompensator => linearShuntCompensator.linearShuntCompensatorId !== id)});
        });
    }
    viewLinearShuntCompensator(id){
        this.props.history.push(`/view-linearShuntCompensator/${id}`);
    }
    editLinearShuntCompensator(id){
        this.props.history.push(`/add-linearShuntCompensator/${id}`);
    }

    componentDidMount(){
        LinearShuntCompensatorService.getLinearShuntCompensators().then((res) => {
            this.setState({ linearShuntCompensators: res.data});
        });
    }

    addLinearShuntCompensator(){
        this.props.history.push('/add-linearShuntCompensator/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LinearShuntCompensator List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLinearShuntCompensator}> Add LinearShuntCompensator</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> B0PerSection </th>
                                    <th> BPerSection </th>
                                    <th> G0PerSection </th>
                                    <th> GPerSection </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.linearShuntCompensators.map(
                                        linearShuntCompensator => 
                                        <tr key = {linearShuntCompensator.linearShuntCompensatorId}>
                                             <td> { linearShuntCompensator.b0PerSection } </td>
                                             <td> { linearShuntCompensator.bPerSection } </td>
                                             <td> { linearShuntCompensator.g0PerSection } </td>
                                             <td> { linearShuntCompensator.gPerSection } </td>
                                             <td>
                                                 <button onClick={ () => this.editLinearShuntCompensator(linearShuntCompensator.linearShuntCompensatorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLinearShuntCompensator(linearShuntCompensator.linearShuntCompensatorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLinearShuntCompensator(linearShuntCompensator.linearShuntCompensatorId)} className="btn btn-info btn-sm">View </button>
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

export default ListLinearShuntCompensatorComponent
