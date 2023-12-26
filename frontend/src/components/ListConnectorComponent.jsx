import React, { Component } from 'react'
import ConnectorService from '../services/ConnectorService'

class ListConnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                connectors: []
        }
        this.addConnector = this.addConnector.bind(this);
        this.editConnector = this.editConnector.bind(this);
        this.deleteConnector = this.deleteConnector.bind(this);
    }

    deleteConnector(id){
        ConnectorService.deleteConnector(id).then( res => {
            this.setState({connectors: this.state.connectors.filter(connector => connector.connectorId !== id)});
        });
    }
    viewConnector(id){
        this.props.history.push(`/view-connector/${id}`);
    }
    editConnector(id){
        this.props.history.push(`/add-connector/${id}`);
    }

    componentDidMount(){
        ConnectorService.getConnectors().then((res) => {
            this.setState({ connectors: res.data});
        });
    }

    addConnector(){
        this.props.history.push('/add-connector/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Connector List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addConnector}> Add Connector</button>
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
                                    this.state.connectors.map(
                                        connector => 
                                        <tr key = {connector.connectorId}>
                                             <td>
                                                 <button onClick={ () => this.editConnector(connector.connectorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteConnector(connector.connectorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewConnector(connector.connectorId)} className="btn btn-info btn-sm">View </button>
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

export default ListConnectorComponent
