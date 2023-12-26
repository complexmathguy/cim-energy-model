import React, { Component } from 'react'
import DisconnectorService from '../services/DisconnectorService';

class UpdateDisconnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDisconnector = this.updateDisconnector.bind(this);

    }

    componentDidMount(){
        DisconnectorService.getDisconnectorById(this.state.id).then( (res) =>{
            let disconnector = res.data;
            this.setState({
            });
        });
    }

    updateDisconnector = (e) => {
        e.preventDefault();
        let disconnector = {
            disconnectorId: this.state.id,
        };
        console.log('disconnector => ' + JSON.stringify(disconnector));
        console.log('id => ' + JSON.stringify(this.state.id));
        DisconnectorService.updateDisconnector(disconnector).then( res => {
            this.props.history.push('/disconnectors');
        });
    }


    cancel(){
        this.props.history.push('/disconnectors');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update Disconnector</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDisconnector}>Save</button>
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

export default UpdateDisconnectorComponent
