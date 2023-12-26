import React, { Component } from 'react'
import ConnectivityNodeContainerService from '../services/ConnectivityNodeContainerService';

class UpdateConnectivityNodeContainerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateConnectivityNodeContainer = this.updateConnectivityNodeContainer.bind(this);

    }

    componentDidMount(){
        ConnectivityNodeContainerService.getConnectivityNodeContainerById(this.state.id).then( (res) =>{
            let connectivityNodeContainer = res.data;
            this.setState({
            });
        });
    }

    updateConnectivityNodeContainer = (e) => {
        e.preventDefault();
        let connectivityNodeContainer = {
            connectivityNodeContainerId: this.state.id,
        };
        console.log('connectivityNodeContainer => ' + JSON.stringify(connectivityNodeContainer));
        console.log('id => ' + JSON.stringify(this.state.id));
        ConnectivityNodeContainerService.updateConnectivityNodeContainer(connectivityNodeContainer).then( res => {
            this.props.history.push('/connectivityNodeContainers');
        });
    }


    cancel(){
        this.props.history.push('/connectivityNodeContainers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ConnectivityNodeContainer</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateConnectivityNodeContainer}>Save</button>
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

export default UpdateConnectivityNodeContainerComponent
