import React, { Component } from 'react'
import ExcitationSystemUserDefinedService from '../services/ExcitationSystemUserDefinedService'

class ListExcitationSystemUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                excitationSystemUserDefineds: []
        }
        this.addExcitationSystemUserDefined = this.addExcitationSystemUserDefined.bind(this);
        this.editExcitationSystemUserDefined = this.editExcitationSystemUserDefined.bind(this);
        this.deleteExcitationSystemUserDefined = this.deleteExcitationSystemUserDefined.bind(this);
    }

    deleteExcitationSystemUserDefined(id){
        ExcitationSystemUserDefinedService.deleteExcitationSystemUserDefined(id).then( res => {
            this.setState({excitationSystemUserDefineds: this.state.excitationSystemUserDefineds.filter(excitationSystemUserDefined => excitationSystemUserDefined.excitationSystemUserDefinedId !== id)});
        });
    }
    viewExcitationSystemUserDefined(id){
        this.props.history.push(`/view-excitationSystemUserDefined/${id}`);
    }
    editExcitationSystemUserDefined(id){
        this.props.history.push(`/add-excitationSystemUserDefined/${id}`);
    }

    componentDidMount(){
        ExcitationSystemUserDefinedService.getExcitationSystemUserDefineds().then((res) => {
            this.setState({ excitationSystemUserDefineds: res.data});
        });
    }

    addExcitationSystemUserDefined(){
        this.props.history.push('/add-excitationSystemUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExcitationSystemUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExcitationSystemUserDefined}> Add ExcitationSystemUserDefined</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Proprietary </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.excitationSystemUserDefineds.map(
                                        excitationSystemUserDefined => 
                                        <tr key = {excitationSystemUserDefined.excitationSystemUserDefinedId}>
                                             <td> { excitationSystemUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editExcitationSystemUserDefined(excitationSystemUserDefined.excitationSystemUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExcitationSystemUserDefined(excitationSystemUserDefined.excitationSystemUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExcitationSystemUserDefined(excitationSystemUserDefined.excitationSystemUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListExcitationSystemUserDefinedComponent
