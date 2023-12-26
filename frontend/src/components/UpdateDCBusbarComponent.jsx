import React, { Component } from 'react'
import DCBusbarService from '../services/DCBusbarService';

class UpdateDCBusbarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDCBusbar = this.updateDCBusbar.bind(this);

    }

    componentDidMount(){
        DCBusbarService.getDCBusbarById(this.state.id).then( (res) =>{
            let dCBusbar = res.data;
            this.setState({
            });
        });
    }

    updateDCBusbar = (e) => {
        e.preventDefault();
        let dCBusbar = {
            dCBusbarId: this.state.id,
        };
        console.log('dCBusbar => ' + JSON.stringify(dCBusbar));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCBusbarService.updateDCBusbar(dCBusbar).then( res => {
            this.props.history.push('/dCBusbars');
        });
    }


    cancel(){
        this.props.history.push('/dCBusbars');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCBusbar</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCBusbar}>Save</button>
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

export default UpdateDCBusbarComponent
