import React, { Component } from 'react'
import ENTSOEConnectivityNodeService from '../services/ENTSOEConnectivityNodeService';

class UpdateENTSOEConnectivityNodeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateENTSOEConnectivityNode = this.updateENTSOEConnectivityNode.bind(this);

    }

    componentDidMount(){
        ENTSOEConnectivityNodeService.getENTSOEConnectivityNodeById(this.state.id).then( (res) =>{
            let eNTSOEConnectivityNode = res.data;
            this.setState({
            });
        });
    }

    updateENTSOEConnectivityNode = (e) => {
        e.preventDefault();
        let eNTSOEConnectivityNode = {
            eNTSOEConnectivityNodeId: this.state.id,
        };
        console.log('eNTSOEConnectivityNode => ' + JSON.stringify(eNTSOEConnectivityNode));
        console.log('id => ' + JSON.stringify(this.state.id));
        ENTSOEConnectivityNodeService.updateENTSOEConnectivityNode(eNTSOEConnectivityNode).then( res => {
            this.props.history.push('/eNTSOEConnectivityNodes');
        });
    }


    cancel(){
        this.props.history.push('/eNTSOEConnectivityNodes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ENTSOEConnectivityNode</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateENTSOEConnectivityNode}>Save</button>
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

export default UpdateENTSOEConnectivityNodeComponent
