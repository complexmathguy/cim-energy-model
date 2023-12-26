import React, { Component } from 'react'
import NonlinearShuntCompensatorService from '../services/NonlinearShuntCompensatorService'

class ListNonlinearShuntCompensatorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                nonlinearShuntCompensators: []
        }
        this.addNonlinearShuntCompensator = this.addNonlinearShuntCompensator.bind(this);
        this.editNonlinearShuntCompensator = this.editNonlinearShuntCompensator.bind(this);
        this.deleteNonlinearShuntCompensator = this.deleteNonlinearShuntCompensator.bind(this);
    }

    deleteNonlinearShuntCompensator(id){
        NonlinearShuntCompensatorService.deleteNonlinearShuntCompensator(id).then( res => {
            this.setState({nonlinearShuntCompensators: this.state.nonlinearShuntCompensators.filter(nonlinearShuntCompensator => nonlinearShuntCompensator.nonlinearShuntCompensatorId !== id)});
        });
    }
    viewNonlinearShuntCompensator(id){
        this.props.history.push(`/view-nonlinearShuntCompensator/${id}`);
    }
    editNonlinearShuntCompensator(id){
        this.props.history.push(`/add-nonlinearShuntCompensator/${id}`);
    }

    componentDidMount(){
        NonlinearShuntCompensatorService.getNonlinearShuntCompensators().then((res) => {
            this.setState({ nonlinearShuntCompensators: res.data});
        });
    }

    addNonlinearShuntCompensator(){
        this.props.history.push('/add-nonlinearShuntCompensator/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">NonlinearShuntCompensator List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addNonlinearShuntCompensator}> Add NonlinearShuntCompensator</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.nonlinearShuntCompensators.map(
                                        nonlinearShuntCompensator => 
                                        <tr key = {nonlinearShuntCompensator.nonlinearShuntCompensatorId}>
                                             <td>
                                                 <button onClick={ () => this.editNonlinearShuntCompensator(nonlinearShuntCompensator.nonlinearShuntCompensatorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteNonlinearShuntCompensator(nonlinearShuntCompensator.nonlinearShuntCompensatorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewNonlinearShuntCompensator(nonlinearShuntCompensator.nonlinearShuntCompensatorId)} className="btn btn-info btn-sm">View </button>
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

export default ListNonlinearShuntCompensatorComponent
