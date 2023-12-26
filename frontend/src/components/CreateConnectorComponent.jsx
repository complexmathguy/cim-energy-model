import React, { Component } from 'react'
import ConnectorService from '../services/ConnectorService';

class CreateConnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            ConnectorService.getConnectorById(this.state.id).then( (res) =>{
                let connector = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateConnector = (e) => {
        e.preventDefault();
        let connector = {
                connectorId: this.state.id,
            };
        console.log('connector => ' + JSON.stringify(connector));

        // step 5
        if(this.state.id === '_add'){
            connector.connectorId=''
            ConnectorService.createConnector(connector).then(res =>{
                this.props.history.push('/connectors');
            });
        }else{
            ConnectorService.updateConnector(connector).then( res => {
                this.props.history.push('/connectors');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/connectors');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Connector</h3>
        }else{
            return <h3 className="text-center">Update Connector</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateConnector}>Save</button>
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

export default CreateConnectorComponent
