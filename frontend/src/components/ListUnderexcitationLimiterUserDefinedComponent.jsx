import React, { Component } from 'react'
import UnderexcitationLimiterUserDefinedService from '../services/UnderexcitationLimiterUserDefinedService'

class ListUnderexcitationLimiterUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                underexcitationLimiterUserDefineds: []
        }
        this.addUnderexcitationLimiterUserDefined = this.addUnderexcitationLimiterUserDefined.bind(this);
        this.editUnderexcitationLimiterUserDefined = this.editUnderexcitationLimiterUserDefined.bind(this);
        this.deleteUnderexcitationLimiterUserDefined = this.deleteUnderexcitationLimiterUserDefined.bind(this);
    }

    deleteUnderexcitationLimiterUserDefined(id){
        UnderexcitationLimiterUserDefinedService.deleteUnderexcitationLimiterUserDefined(id).then( res => {
            this.setState({underexcitationLimiterUserDefineds: this.state.underexcitationLimiterUserDefineds.filter(underexcitationLimiterUserDefined => underexcitationLimiterUserDefined.underexcitationLimiterUserDefinedId !== id)});
        });
    }
    viewUnderexcitationLimiterUserDefined(id){
        this.props.history.push(`/view-underexcitationLimiterUserDefined/${id}`);
    }
    editUnderexcitationLimiterUserDefined(id){
        this.props.history.push(`/add-underexcitationLimiterUserDefined/${id}`);
    }

    componentDidMount(){
        UnderexcitationLimiterUserDefinedService.getUnderexcitationLimiterUserDefineds().then((res) => {
            this.setState({ underexcitationLimiterUserDefineds: res.data});
        });
    }

    addUnderexcitationLimiterUserDefined(){
        this.props.history.push('/add-underexcitationLimiterUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">UnderexcitationLimiterUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addUnderexcitationLimiterUserDefined}> Add UnderexcitationLimiterUserDefined</button>
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
                                    this.state.underexcitationLimiterUserDefineds.map(
                                        underexcitationLimiterUserDefined => 
                                        <tr key = {underexcitationLimiterUserDefined.underexcitationLimiterUserDefinedId}>
                                             <td> { underexcitationLimiterUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editUnderexcitationLimiterUserDefined(underexcitationLimiterUserDefined.underexcitationLimiterUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUnderexcitationLimiterUserDefined(underexcitationLimiterUserDefined.underexcitationLimiterUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUnderexcitationLimiterUserDefined(underexcitationLimiterUserDefined.underexcitationLimiterUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListUnderexcitationLimiterUserDefinedComponent
