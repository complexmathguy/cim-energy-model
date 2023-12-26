import React, { Component } from 'react'
import OverexcitationLimiterDynamicsService from '../services/OverexcitationLimiterDynamicsService'

class ListOverexcitationLimiterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                overexcitationLimiterDynamicss: []
        }
        this.addOverexcitationLimiterDynamics = this.addOverexcitationLimiterDynamics.bind(this);
        this.editOverexcitationLimiterDynamics = this.editOverexcitationLimiterDynamics.bind(this);
        this.deleteOverexcitationLimiterDynamics = this.deleteOverexcitationLimiterDynamics.bind(this);
    }

    deleteOverexcitationLimiterDynamics(id){
        OverexcitationLimiterDynamicsService.deleteOverexcitationLimiterDynamics(id).then( res => {
            this.setState({overexcitationLimiterDynamicss: this.state.overexcitationLimiterDynamicss.filter(overexcitationLimiterDynamics => overexcitationLimiterDynamics.overexcitationLimiterDynamicsId !== id)});
        });
    }
    viewOverexcitationLimiterDynamics(id){
        this.props.history.push(`/view-overexcitationLimiterDynamics/${id}`);
    }
    editOverexcitationLimiterDynamics(id){
        this.props.history.push(`/add-overexcitationLimiterDynamics/${id}`);
    }

    componentDidMount(){
        OverexcitationLimiterDynamicsService.getOverexcitationLimiterDynamicss().then((res) => {
            this.setState({ overexcitationLimiterDynamicss: res.data});
        });
    }

    addOverexcitationLimiterDynamics(){
        this.props.history.push('/add-overexcitationLimiterDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">OverexcitationLimiterDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addOverexcitationLimiterDynamics}> Add OverexcitationLimiterDynamics</button>
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
                                    this.state.overexcitationLimiterDynamicss.map(
                                        overexcitationLimiterDynamics => 
                                        <tr key = {overexcitationLimiterDynamics.overexcitationLimiterDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editOverexcitationLimiterDynamics(overexcitationLimiterDynamics.overexcitationLimiterDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteOverexcitationLimiterDynamics(overexcitationLimiterDynamics.overexcitationLimiterDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewOverexcitationLimiterDynamics(overexcitationLimiterDynamics.overexcitationLimiterDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListOverexcitationLimiterDynamicsComponent
