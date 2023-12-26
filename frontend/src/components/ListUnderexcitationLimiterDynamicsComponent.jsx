import React, { Component } from 'react'
import UnderexcitationLimiterDynamicsService from '../services/UnderexcitationLimiterDynamicsService'

class ListUnderexcitationLimiterDynamicsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                underexcitationLimiterDynamicss: []
        }
        this.addUnderexcitationLimiterDynamics = this.addUnderexcitationLimiterDynamics.bind(this);
        this.editUnderexcitationLimiterDynamics = this.editUnderexcitationLimiterDynamics.bind(this);
        this.deleteUnderexcitationLimiterDynamics = this.deleteUnderexcitationLimiterDynamics.bind(this);
    }

    deleteUnderexcitationLimiterDynamics(id){
        UnderexcitationLimiterDynamicsService.deleteUnderexcitationLimiterDynamics(id).then( res => {
            this.setState({underexcitationLimiterDynamicss: this.state.underexcitationLimiterDynamicss.filter(underexcitationLimiterDynamics => underexcitationLimiterDynamics.underexcitationLimiterDynamicsId !== id)});
        });
    }
    viewUnderexcitationLimiterDynamics(id){
        this.props.history.push(`/view-underexcitationLimiterDynamics/${id}`);
    }
    editUnderexcitationLimiterDynamics(id){
        this.props.history.push(`/add-underexcitationLimiterDynamics/${id}`);
    }

    componentDidMount(){
        UnderexcitationLimiterDynamicsService.getUnderexcitationLimiterDynamicss().then((res) => {
            this.setState({ underexcitationLimiterDynamicss: res.data});
        });
    }

    addUnderexcitationLimiterDynamics(){
        this.props.history.push('/add-underexcitationLimiterDynamics/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">UnderexcitationLimiterDynamics List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addUnderexcitationLimiterDynamics}> Add UnderexcitationLimiterDynamics</button>
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
                                    this.state.underexcitationLimiterDynamicss.map(
                                        underexcitationLimiterDynamics => 
                                        <tr key = {underexcitationLimiterDynamics.underexcitationLimiterDynamicsId}>
                                             <td>
                                                 <button onClick={ () => this.editUnderexcitationLimiterDynamics(underexcitationLimiterDynamics.underexcitationLimiterDynamicsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUnderexcitationLimiterDynamics(underexcitationLimiterDynamics.underexcitationLimiterDynamicsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUnderexcitationLimiterDynamics(underexcitationLimiterDynamics.underexcitationLimiterDynamicsId)} className="btn btn-info btn-sm">View </button>
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

export default ListUnderexcitationLimiterDynamicsComponent
