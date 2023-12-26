import React, { Component } from 'react'
import TurbineGovernorUserDefinedService from '../services/TurbineGovernorUserDefinedService'

class ListTurbineGovernorUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                turbineGovernorUserDefineds: []
        }
        this.addTurbineGovernorUserDefined = this.addTurbineGovernorUserDefined.bind(this);
        this.editTurbineGovernorUserDefined = this.editTurbineGovernorUserDefined.bind(this);
        this.deleteTurbineGovernorUserDefined = this.deleteTurbineGovernorUserDefined.bind(this);
    }

    deleteTurbineGovernorUserDefined(id){
        TurbineGovernorUserDefinedService.deleteTurbineGovernorUserDefined(id).then( res => {
            this.setState({turbineGovernorUserDefineds: this.state.turbineGovernorUserDefineds.filter(turbineGovernorUserDefined => turbineGovernorUserDefined.turbineGovernorUserDefinedId !== id)});
        });
    }
    viewTurbineGovernorUserDefined(id){
        this.props.history.push(`/view-turbineGovernorUserDefined/${id}`);
    }
    editTurbineGovernorUserDefined(id){
        this.props.history.push(`/add-turbineGovernorUserDefined/${id}`);
    }

    componentDidMount(){
        TurbineGovernorUserDefinedService.getTurbineGovernorUserDefineds().then((res) => {
            this.setState({ turbineGovernorUserDefineds: res.data});
        });
    }

    addTurbineGovernorUserDefined(){
        this.props.history.push('/add-turbineGovernorUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">TurbineGovernorUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addTurbineGovernorUserDefined}> Add TurbineGovernorUserDefined</button>
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
                                    this.state.turbineGovernorUserDefineds.map(
                                        turbineGovernorUserDefined => 
                                        <tr key = {turbineGovernorUserDefined.turbineGovernorUserDefinedId}>
                                             <td> { turbineGovernorUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editTurbineGovernorUserDefined(turbineGovernorUserDefined.turbineGovernorUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteTurbineGovernorUserDefined(turbineGovernorUserDefined.turbineGovernorUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewTurbineGovernorUserDefined(turbineGovernorUserDefined.turbineGovernorUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListTurbineGovernorUserDefinedComponent
