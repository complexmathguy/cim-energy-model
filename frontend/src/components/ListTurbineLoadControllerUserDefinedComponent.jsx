import React, { Component } from 'react'
import TurbineLoadControllerUserDefinedService from '../services/TurbineLoadControllerUserDefinedService'

class ListTurbineLoadControllerUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                turbineLoadControllerUserDefineds: []
        }
        this.addTurbineLoadControllerUserDefined = this.addTurbineLoadControllerUserDefined.bind(this);
        this.editTurbineLoadControllerUserDefined = this.editTurbineLoadControllerUserDefined.bind(this);
        this.deleteTurbineLoadControllerUserDefined = this.deleteTurbineLoadControllerUserDefined.bind(this);
    }

    deleteTurbineLoadControllerUserDefined(id){
        TurbineLoadControllerUserDefinedService.deleteTurbineLoadControllerUserDefined(id).then( res => {
            this.setState({turbineLoadControllerUserDefineds: this.state.turbineLoadControllerUserDefineds.filter(turbineLoadControllerUserDefined => turbineLoadControllerUserDefined.turbineLoadControllerUserDefinedId !== id)});
        });
    }
    viewTurbineLoadControllerUserDefined(id){
        this.props.history.push(`/view-turbineLoadControllerUserDefined/${id}`);
    }
    editTurbineLoadControllerUserDefined(id){
        this.props.history.push(`/add-turbineLoadControllerUserDefined/${id}`);
    }

    componentDidMount(){
        TurbineLoadControllerUserDefinedService.getTurbineLoadControllerUserDefineds().then((res) => {
            this.setState({ turbineLoadControllerUserDefineds: res.data});
        });
    }

    addTurbineLoadControllerUserDefined(){
        this.props.history.push('/add-turbineLoadControllerUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TurbineLoadControllerUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTurbineLoadControllerUserDefined}> Add TurbineLoadControllerUserDefined</button>
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
                                    this.state.turbineLoadControllerUserDefineds.map(
                                        turbineLoadControllerUserDefined => 
                                        <tr key = {turbineLoadControllerUserDefined.turbineLoadControllerUserDefinedId}>
                                             <td> { turbineLoadControllerUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editTurbineLoadControllerUserDefined(turbineLoadControllerUserDefined.turbineLoadControllerUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTurbineLoadControllerUserDefined(turbineLoadControllerUserDefined.turbineLoadControllerUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTurbineLoadControllerUserDefined(turbineLoadControllerUserDefined.turbineLoadControllerUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListTurbineLoadControllerUserDefinedComponent
