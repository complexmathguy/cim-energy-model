import React, { Component } from 'react'
import GroundDisconnectorService from '../services/GroundDisconnectorService';

class UpdateGroundDisconnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateGroundDisconnector = this.updateGroundDisconnector.bind(this);

    }

    componentDidMount(){
        GroundDisconnectorService.getGroundDisconnectorById(this.state.id).then( (res) =>{
            let groundDisconnector = res.data;
            this.setState({
            });
        });
    }

    updateGroundDisconnector = (e) => {
        e.preventDefault();
        let groundDisconnector = {
            groundDisconnectorId: this.state.id,
        };
        console.log('groundDisconnector => ' + JSON.stringify(groundDisconnector));
        console.log('id => ' + JSON.stringify(this.state.id));
        GroundDisconnectorService.updateGroundDisconnector(groundDisconnector).then( res => {
            this.props.history.push('/groundDisconnectors');
        });
    }


    cancel(){
        this.props.history.push('/groundDisconnectors');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update GroundDisconnector</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateGroundDisconnector}>Save</button>
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

export default UpdateGroundDisconnectorComponent
