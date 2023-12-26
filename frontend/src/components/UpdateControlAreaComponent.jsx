import React, { Component } from 'react'
import ControlAreaService from '../services/ControlAreaService';

class UpdateControlAreaComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                type: ''
        }
        this.updateControlArea = this.updateControlArea.bind(this);

        this.changetypeHandler = this.changetypeHandler.bind(this);
    }

    componentDidMount(){
        ControlAreaService.getControlAreaById(this.state.id).then( (res) =>{
            let controlArea = res.data;
            this.setState({
                type: controlArea.type
            });
        });
    }

    updateControlArea = (e) => {
        e.preventDefault();
        let controlArea = {
            controlAreaId: this.state.id,
            type: this.state.type
        };
        console.log('controlArea => ' + JSON.stringify(controlArea));
        console.log('id => ' + JSON.stringify(this.state.id));
        ControlAreaService.updateControlArea(controlArea).then( res => {
            this.props.history.push('/controlAreas');
        });
    }

    changetypeHandler= (event) => {
        this.setState({type: event.target.value});
    }

    cancel(){
        this.props.history.push('/controlAreas');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update ControlArea</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> type: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateControlArea}>Save</button>
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

export default UpdateControlAreaComponent
