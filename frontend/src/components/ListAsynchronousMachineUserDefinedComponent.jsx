import React, { Component } from 'react'
import AsynchronousMachineUserDefinedService from '../services/AsynchronousMachineUserDefinedService'

class ListAsynchronousMachineUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                asynchronousMachineUserDefineds: []
        }
        this.addAsynchronousMachineUserDefined = this.addAsynchronousMachineUserDefined.bind(this);
        this.editAsynchronousMachineUserDefined = this.editAsynchronousMachineUserDefined.bind(this);
        this.deleteAsynchronousMachineUserDefined = this.deleteAsynchronousMachineUserDefined.bind(this);
    }

    deleteAsynchronousMachineUserDefined(id){
        AsynchronousMachineUserDefinedService.deleteAsynchronousMachineUserDefined(id).then( res => {
            this.setState({asynchronousMachineUserDefineds: this.state.asynchronousMachineUserDefineds.filter(asynchronousMachineUserDefined => asynchronousMachineUserDefined.asynchronousMachineUserDefinedId !== id)});
        });
    }
    viewAsynchronousMachineUserDefined(id){
        this.props.history.push(`/view-asynchronousMachineUserDefined/${id}`);
    }
    editAsynchronousMachineUserDefined(id){
        this.props.history.push(`/add-asynchronousMachineUserDefined/${id}`);
    }

    componentDidMount(){
        AsynchronousMachineUserDefinedService.getAsynchronousMachineUserDefineds().then((res) => {
            this.setState({ asynchronousMachineUserDefineds: res.data});
        });
    }

    addAsynchronousMachineUserDefined(){
        this.props.history.push('/add-asynchronousMachineUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">AsynchronousMachineUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addAsynchronousMachineUserDefined}> Add AsynchronousMachineUserDefined</button>
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
                                    this.state.asynchronousMachineUserDefineds.map(
                                        asynchronousMachineUserDefined => 
                                        <tr key = {asynchronousMachineUserDefined.asynchronousMachineUserDefinedId}>
                                             <td> { asynchronousMachineUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editAsynchronousMachineUserDefined(asynchronousMachineUserDefined.asynchronousMachineUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteAsynchronousMachineUserDefined(asynchronousMachineUserDefined.asynchronousMachineUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewAsynchronousMachineUserDefined(asynchronousMachineUserDefined.asynchronousMachineUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListAsynchronousMachineUserDefinedComponent
