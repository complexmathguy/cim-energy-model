import React, { Component } from 'react'
import ConnectorService from '../services/ConnectorService';

class UpdateConnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateConnector = this.updateConnector.bind(this);

    }

    componentDidMount(){
        ConnectorService.getConnectorById(this.state.id).then( (res) =>{
            let connector = res.data;
            this.setState({
            });
        });
    }

    updateConnector = (e) => {
        e.preventDefault();
        let connector = {
            connectorId: this.state.id,
        };
        console.log('connector => ' + JSON.stringify(connector));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConnectorService.updateConnector(connector).then( res => {
            this.props.history.push('/connectors');
        });
    }


    cancel(){
        this.props.history.push('/connectors');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Connector</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConnector}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateConnectorComponent
