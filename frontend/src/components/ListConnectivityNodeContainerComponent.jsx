import React, { Component } from 'react'
import ConnectivityNodeContainerService from '../services/ConnectivityNodeContainerService'

class ListConnectivityNodeContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                connectivityNodeContainers: []
        }
        this.addConnectivityNodeContainer = this.addConnectivityNodeContainer.bind(this);
        this.editConnectivityNodeContainer = this.editConnectivityNodeContainer.bind(this);
        this.deleteConnectivityNodeContainer = this.deleteConnectivityNodeContainer.bind(this);
    }

    deleteConnectivityNodeContainer(id){
        ConnectivityNodeContainerService.deleteConnectivityNodeContainer(id).then( res => {
            this.setState({connectivityNodeContainers: this.state.connectivityNodeContainers.filter(connectivityNodeContainer => connectivityNodeContainer.connectivityNodeContainerId !== id)});
        });
    }
    viewConnectivityNodeContainer(id){
        this.props.history.push(`/view-connectivityNodeContainer/${id}`);
    }
    editConnectivityNodeContainer(id){
        this.props.history.push(`/add-connectivityNodeContainer/${id}`);
    }

    componentDidMount(){
        ConnectivityNodeContainerService.getConnectivityNodeContainers().then((res) => {
            this.setState({ connectivityNodeContainers: res.data});
        });
    }

    addConnectivityNodeContainer(){
        this.props.history.push('/add-connectivityNodeContainer/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ConnectivityNodeContainer List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addConnectivityNodeContainer}> Add ConnectivityNodeContainer</button>
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
                                    this.state.connectivityNodeContainers.map(
                                        connectivityNodeContainer => 
                                        <tr key = {connectivityNodeContainer.connectivityNodeContainerId}>
                                             <td>
                                                 <button onClick={ () => this.editConnectivityNodeContainer(connectivityNodeContainer.connectivityNodeContainerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteConnectivityNodeContainer(connectivityNodeContainer.connectivityNodeContainerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewConnectivityNodeContainer(connectivityNodeContainer.connectivityNodeContainerId)} className="btn btn-info btn-sm">View </button>
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

export default ListConnectivityNodeContainerComponent
