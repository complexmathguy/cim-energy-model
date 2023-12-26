import React, { Component } from 'react'
import EquivalentNetworkService from '../services/EquivalentNetworkService';

class CreateEquivalentNetworkComponent extends Component {
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
            EquivalentNetworkService.getEquivalentNetworkById(this.state.id).then( (res) =>{
                let equivalentNetwork = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdateEquivalentNetwork = (e) => {
        e.preventDefault();
        let equivalentNetwork = {
                equivalentNetworkId: this.state.id,
            };
        console.log('equivalentNetwork => ' + JSON.stringify(equivalentNetwork));

        // step 5
        if(this.state.id === '_add'){
            equivalentNetwork.equivalentNetworkId=''
            EquivalentNetworkService.createEquivalentNetwork(equivalentNetwork).then(res =>{
                this.props.history.push('/equivalentNetworks');
            });
        }else{
            EquivalentNetworkService.updateEquivalentNetwork(equivalentNetwork).then( res => {
                this.props.history.push('/equivalentNetworks');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/equivalentNetworks');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add EquivalentNetwork</h3>
        }else{
            return <h3 className="text-center">Update EquivalentNetwork</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdateEquivalentNetwork}>Save</button>
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

export default CreateEquivalentNetworkComponent
