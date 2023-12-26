import React, { Component } from 'react'
import TapChangerControlService from '../services/TapChangerControlService';

class UpdateTapChangerControlComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateTapChangerControl = this.updateTapChangerControl.bind(this);

    }

    componentDidMount(){
        TapChangerControlService.getTapChangerControlById(this.state.id).then( (res) =>{
            let tapChangerControl = res.data;
            this.setState({
            });
        });
    }

    updateTapChangerControl = (e) => {
        e.preventDefault();
        let tapChangerControl = {
            tapChangerControlId: this.state.id,
        };
        console.log('tapChangerControl => ' + JSON.stringify(tapChangerControl));
        console.log('id => ' + JSON.stringify(this.state.id));
        TapChangerControlService.updateTapChangerControl(tapChangerControl).then( res => {
            this.props.history.push('/tapChangerControls');
        });
    }


    cancel(){
        this.props.history.push('/tapChangerControls');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update TapChangerControl</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateTapChangerControl}>Save</button>
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

export default UpdateTapChangerControlComponent
