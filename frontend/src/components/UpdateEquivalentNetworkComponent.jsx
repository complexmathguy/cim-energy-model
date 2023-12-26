import React, { Component } from 'react'
import EquivalentNetworkService from '../services/EquivalentNetworkService';

class UpdateEquivalentNetworkComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateEquivalentNetwork = this.updateEquivalentNetwork.bind(this);

    }

    componentDidMount(){
        EquivalentNetworkService.getEquivalentNetworkById(this.state.id).then( (res) =>{
            let equivalentNetwork = res.data;
            this.setState({
            });
        });
    }

    updateEquivalentNetwork = (e) => {
        e.preventDefault();
        let equivalentNetwork = {
            equivalentNetworkId: this.state.id,
        };
        console.log('equivalentNetwork => ' + JSON.stringify(equivalentNetwork));
        console.log('id => ' + JSON.stringify(this.state.id));
        EquivalentNetworkService.updateEquivalentNetwork(equivalentNetwork).then( res => {
            this.props.history.push('/equivalentNetworks');
        });
    }


    cancel(){
        this.props.history.push('/equivalentNetworks');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update EquivalentNetwork</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateEquivalentNetwork}>Save</button>
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

export default UpdateEquivalentNetworkComponent
