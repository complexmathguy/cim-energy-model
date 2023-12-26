import React, { Component } from 'react'
import WindContPType4aIECService from '../services/WindContPType4aIECService';

class UpdateWindContPType4aIECComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                dpmax: '',
                tpord: '',
                tufilt: ''
        }
        this.updateWindContPType4aIEC = this.updateWindContPType4aIEC.bind(this);

        this.changedpmaxHandler = this.changedpmaxHandler.bind(this);
        this.changetpordHandler = this.changetpordHandler.bind(this);
        this.changetufiltHandler = this.changetufiltHandler.bind(this);
    }

    componentDidMount(){
        WindContPType4aIECService.getWindContPType4aIECById(this.state.id).then( (res) =>{
            let windContPType4aIEC = res.data;
            this.setState({
                dpmax: windContPType4aIEC.dpmax,
                tpord: windContPType4aIEC.tpord,
                tufilt: windContPType4aIEC.tufilt
            });
        });
    }

    updateWindContPType4aIEC = (e) => {
        e.preventDefault();
        let windContPType4aIEC = {
            windContPType4aIECId: this.state.id,
            dpmax: this.state.dpmax,
            tpord: this.state.tpord,
            tufilt: this.state.tufilt
        };
        console.log('windContPType4aIEC => ' + JSON.stringify(windContPType4aIEC));
        console.log('id => ' + JSON.stringify(this.state.id));
        WindContPType4aIECService.updateWindContPType4aIEC(windContPType4aIEC).then( res => {
            this.props.history.push('/windContPType4aIECs');
        });
    }

    changedpmaxHandler= (event) => {
        this.setState({dpmax: event.target.value});
    }
    changetpordHandler= (event) => {
        this.setState({tpord: event.target.value});
    }
    changetufiltHandler= (event) => {
        this.setState({tufilt: event.target.value});
    }

    cancel(){
        this.props.history.push('/windContPType4aIECs');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update WindContPType4aIEC</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> dpmax: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tpord: </label>
                                            #formFields( $attribute, 'update')
                                            <label> tufilt: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateWindContPType4aIEC}>Save</button>
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

export default UpdateWindContPType4aIECComponent
