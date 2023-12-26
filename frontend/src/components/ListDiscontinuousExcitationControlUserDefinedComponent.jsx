import React, { Component } from 'react'
import DiscontinuousExcitationControlUserDefinedService from '../services/DiscontinuousExcitationControlUserDefinedService'

class ListDiscontinuousExcitationControlUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                discontinuousExcitationControlUserDefineds: []
        }
        this.addDiscontinuousExcitationControlUserDefined = this.addDiscontinuousExcitationControlUserDefined.bind(this);
        this.editDiscontinuousExcitationControlUserDefined = this.editDiscontinuousExcitationControlUserDefined.bind(this);
        this.deleteDiscontinuousExcitationControlUserDefined = this.deleteDiscontinuousExcitationControlUserDefined.bind(this);
    }

    deleteDiscontinuousExcitationControlUserDefined(id){
        DiscontinuousExcitationControlUserDefinedService.deleteDiscontinuousExcitationControlUserDefined(id).then( res => {
            this.setState({discontinuousExcitationControlUserDefineds: this.state.discontinuousExcitationControlUserDefineds.filter(discontinuousExcitationControlUserDefined => discontinuousExcitationControlUserDefined.discontinuousExcitationControlUserDefinedId !== id)});
        });
    }
    viewDiscontinuousExcitationControlUserDefined(id){
        this.props.history.push(`/view-discontinuousExcitationControlUserDefined/${id}`);
    }
    editDiscontinuousExcitationControlUserDefined(id){
        this.props.history.push(`/add-discontinuousExcitationControlUserDefined/${id}`);
    }

    componentDidMount(){
        DiscontinuousExcitationControlUserDefinedService.getDiscontinuousExcitationControlUserDefineds().then((res) => {
            this.setState({ discontinuousExcitationControlUserDefineds: res.data});
        });
    }

    addDiscontinuousExcitationControlUserDefined(){
        this.props.history.push('/add-discontinuousExcitationControlUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiscontinuousExcitationControlUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiscontinuousExcitationControlUserDefined}> Add DiscontinuousExcitationControlUserDefined</button>
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
                                    this.state.discontinuousExcitationControlUserDefineds.map(
                                        discontinuousExcitationControlUserDefined => 
                                        <tr key = {discontinuousExcitationControlUserDefined.discontinuousExcitationControlUserDefinedId}>
                                             <td> { discontinuousExcitationControlUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editDiscontinuousExcitationControlUserDefined(discontinuousExcitationControlUserDefined.discontinuousExcitationControlUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiscontinuousExcitationControlUserDefined(discontinuousExcitationControlUserDefined.discontinuousExcitationControlUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiscontinuousExcitationControlUserDefined(discontinuousExcitationControlUserDefined.discontinuousExcitationControlUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiscontinuousExcitationControlUserDefinedComponent
