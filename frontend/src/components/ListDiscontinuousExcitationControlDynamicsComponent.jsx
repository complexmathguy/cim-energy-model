import React, { Component } from 'react'
import DiscontinuousExcitationControlDynamicsService from '../services/DiscontinuousExcitationControlDynamicsService'

class ListDiscontinuousExcitationControlDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                discontinuousExcitationControlDynamicss: []
        }
        this.addDiscontinuousExcitationControlDynamics = this.addDiscontinuousExcitationControlDynamics.bind(this);
        this.editDiscontinuousExcitationControlDynamics = this.editDiscontinuousExcitationControlDynamics.bind(this);
        this.deleteDiscontinuousExcitationControlDynamics = this.deleteDiscontinuousExcitationControlDynamics.bind(this);
    }

    deleteDiscontinuousExcitationControlDynamics(id){
        DiscontinuousExcitationControlDynamicsService.deleteDiscontinuousExcitationControlDynamics(id).then( res => {
            this.setState({discontinuousExcitationControlDynamicss: this.state.discontinuousExcitationControlDynamicss.filter(discontinuousExcitationControlDynamics => discontinuousExcitationControlDynamics.discontinuousExcitationControlDynamicsId !== id)});
        });
    }
    viewDiscontinuousExcitationControlDynamics(id){
        this.props.history.push(`/view-discontinuousExcitationControlDynamics/${id}`);
    }
    editDiscontinuousExcitationControlDynamics(id){
        this.props.history.push(`/add-discontinuousExcitationControlDynamics/${id}`);
    }

    componentDidMount(){
        DiscontinuousExcitationControlDynamicsService.getDiscontinuousExcitationControlDynamicss().then((res) => {
            this.setState({ discontinuousExcitationControlDynamicss: res.data});
        });
    }

    addDiscontinuousExcitationControlDynamics(){
        this.props.history.push('/add-discontinuousExcitationControlDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DiscontinuousExcitationControlDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDiscontinuousExcitationControlDynamics}> Add DiscontinuousExcitationControlDynamics</button>
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
                                    this.state.discontinuousExcitationControlDynamicss.map(
                                        discontinuousExcitationControlDynamics => 
                                        <tr key = {discontinuousExcitationControlDynamics.discontinuousExcitationControlDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editDiscontinuousExcitationControlDynamics(discontinuousExcitationControlDynamics.discontinuousExcitationControlDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDiscontinuousExcitationControlDynamics(discontinuousExcitationControlDynamics.discontinuousExcitationControlDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDiscontinuousExcitationControlDynamics(discontinuousExcitationControlDynamics.discontinuousExcitationControlDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListDiscontinuousExcitationControlDynamicsComponent
