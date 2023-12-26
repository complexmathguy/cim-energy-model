import React, { Component } from 'react'
import OverexcitationLimiterUserDefinedService from '../services/OverexcitationLimiterUserDefinedService'

class ListOverexcitationLimiterUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                overexcitationLimiterUserDefineds: []
        }
        this.addOverexcitationLimiterUserDefined = this.addOverexcitationLimiterUserDefined.bind(this);
        this.editOverexcitationLimiterUserDefined = this.editOverexcitationLimiterUserDefined.bind(this);
        this.deleteOverexcitationLimiterUserDefined = this.deleteOverexcitationLimiterUserDefined.bind(this);
    }

    deleteOverexcitationLimiterUserDefined(id){
        OverexcitationLimiterUserDefinedService.deleteOverexcitationLimiterUserDefined(id).then( res => {
            this.setState({overexcitationLimiterUserDefineds: this.state.overexcitationLimiterUserDefineds.filter(overexcitationLimiterUserDefined => overexcitationLimiterUserDefined.overexcitationLimiterUserDefinedId !== id)});
        });
    }
    viewOverexcitationLimiterUserDefined(id){
        this.props.history.push(`/view-overexcitationLimiterUserDefined/${id}`);
    }
    editOverexcitationLimiterUserDefined(id){
        this.props.history.push(`/add-overexcitationLimiterUserDefined/${id}`);
    }

    componentDidMount(){
        OverexcitationLimiterUserDefinedService.getOverexcitationLimiterUserDefineds().then((res) => {
            this.setState({ overexcitationLimiterUserDefineds: res.data});
        });
    }

    addOverexcitationLimiterUserDefined(){
        this.props.history.push('/add-overexcitationLimiterUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">OverexcitationLimiterUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addOverexcitationLimiterUserDefined}> Add OverexcitationLimiterUserDefined</button>
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
                                    this.state.overexcitationLimiterUserDefineds.map(
                                        overexcitationLimiterUserDefined => 
                                        <tr key = {overexcitationLimiterUserDefined.overexcitationLimiterUserDefinedId}>
                                             <td> { overexcitationLimiterUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editOverexcitationLimiterUserDefined(overexcitationLimiterUserDefined.overexcitationLimiterUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteOverexcitationLimiterUserDefined(overexcitationLimiterUserDefined.overexcitationLimiterUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewOverexcitationLimiterUserDefined(overexcitationLimiterUserDefined.overexcitationLimiterUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListOverexcitationLimiterUserDefinedComponent
