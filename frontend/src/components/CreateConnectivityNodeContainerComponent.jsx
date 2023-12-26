import React, { Component } from 'react'
import ConnectivityNodeContainerService from '../services/ConnectivityNodeContainerService';

class CreateConnectivityNodeContainerComponent extends Component {
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
            ConnectivityNodeContainerService.getConnectivityNodeContainerById(this.state.id).then( (res) =>{
                let connectivityNodeContainer = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateConnectivityNodeContainer = (e) => {
        e.preventDefault();
        let connectivityNodeContainer = {
                connectivityNodeContainerId: this.state.id,
            };
        console.log('connectivityNodeContainer => ' + JSON.stringify(connectivityNodeContainer));

        // step 5
        if(this.state.id === '_add'){
            connectivityNodeContainer.connectivityNodeContainerId=''
            ConnectivityNodeContainerService.createConnectivityNodeContainer(connectivityNodeContainer).then(res =>{
                this.props.history.push('/connectivityNodeContainers');
            });
        }else{
            ConnectivityNodeContainerService.updateConnectivityNodeContainer(connectivityNodeContainer).then( res => {
                this.props.history.push('/connectivityNodeContainers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/connectivityNodeContainers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add ConnectivityNodeContainer</h3>
        }else{
            return <h3 className="text-center">Update ConnectivityNodeContainer</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateConnectivityNodeContainer}>Save</button>
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

export default CreateConnectivityNodeContainerComponent
