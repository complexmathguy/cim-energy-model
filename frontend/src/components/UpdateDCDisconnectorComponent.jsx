import React, { Component } from 'react'
import DCDisconnectorService from '../services/DCDisconnectorService';

class UpdateDCDisconnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCDisconnector = this.updateDCDisconnector.bind(this);

    }

    componentDidMount(){
        DCDisconnectorService.getDCDisconnectorById(this.state.id).then( (res) =>{
            let dCDisconnector = res.data;
            this.setState({
            });
        });
    }

    updateDCDisconnector = (e) => {
        e.preventDefault();
        let dCDisconnector = {
            dCDisconnectorId: this.state.id,
        };
        console.log('dCDisconnector => ' + JSON.stringify(dCDisconnector));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCDisconnectorService.updateDCDisconnector(dCDisconnector).then( res => {
            this.props.history.push('/dCDisconnectors');
        });
    }


    cancel(){
        this.props.history.push('/dCDisconnectors');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCDisconnector</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCDisconnector}>Save</button>
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

export default UpdateDCDisconnectorComponent
