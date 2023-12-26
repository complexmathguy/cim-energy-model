import React, { Component } from 'react'
import SvPowerFlowService from '../services/SvPowerFlowService'

class ListSvPowerFlowComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                svPowerFlows: []
        }
        this.addSvPowerFlow = this.addSvPowerFlow.bind(this);
        this.editSvPowerFlow = this.editSvPowerFlow.bind(this);
        this.deleteSvPowerFlow = this.deleteSvPowerFlow.bind(this);
    }

    deleteSvPowerFlow(id){
        SvPowerFlowService.deleteSvPowerFlow(id).then( res => {
            this.setState({svPowerFlows: this.state.svPowerFlows.filter(svPowerFlow => svPowerFlow.svPowerFlowId !== id)});
        });
    }
    viewSvPowerFlow(id){
        this.props.history.push(`/view-svPowerFlow/${id}`);
    }
    editSvPowerFlow(id){
        this.props.history.push(`/add-svPowerFlow/${id}`);
    }

    componentDidMount(){
        SvPowerFlowService.getSvPowerFlows().then((res) => {
            this.setState({ svPowerFlows: res.data});
        });
    }

    addSvPowerFlow(){
        this.props.history.push('/add-svPowerFlow/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SvPowerFlow List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSvPowerFlow}> Add SvPowerFlow</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> P </th>
                                    <th> Q </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.svPowerFlows.map(
                                        svPowerFlow => 
                                        <tr key = {svPowerFlow.svPowerFlowId}>
                                             <td> { svPowerFlow.p } </td>
                                             <td> { svPowerFlow.q } </td>
                                             <td>
                                                 <button onClick={ () => this.editSvPowerFlow(svPowerFlow.svPowerFlowId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSvPowerFlow(svPowerFlow.svPowerFlowId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSvPowerFlow(svPowerFlow.svPowerFlowId)} className="btn btn-info btn-sm">View </button>
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

export default ListSvPowerFlowComponent
