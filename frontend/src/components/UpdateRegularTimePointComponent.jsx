import React, { Component } from 'react'
import RegularTimePointService from '../services/RegularTimePointService';

class UpdateRegularTimePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                sequenceNumber: '',
                value1: '',
                value2: ''
        }
        this.updateRegularTimePoint = this.updateRegularTimePoint.bind(this);

        this.changesequenceNumberHandler = this.changesequenceNumberHandler.bind(this);
        this.changevalue1Handler = this.changevalue1Handler.bind(this);
        this.changevalue2Handler = this.changevalue2Handler.bind(this);
    }

    componentDidMount(){
        RegularTimePointService.getRegularTimePointById(this.state.id).then( (res) =>{
            let regularTimePoint = res.data;
            this.setState({
                sequenceNumber: regularTimePoint.sequenceNumber,
                value1: regularTimePoint.value1,
                value2: regularTimePoint.value2
            });
        });
    }

    updateRegularTimePoint = (e) => {
        e.preventDefault();
        let regularTimePoint = {
            regularTimePointId: this.state.id,
            sequenceNumber: this.state.sequenceNumber,
            value1: this.state.value1,
            value2: this.state.value2
        };
        console.log('regularTimePoint => ' + JSON.stringify(regularTimePoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        RegularTimePointService.updateRegularTimePoint(regularTimePoint).then( res => {
            this.props.history.push('/regularTimePoints');
        });
    }

    changesequenceNumberHandler= (event) => {
        this.setState({sequenceNumber: event.target.value});
    }
    changevalue1Handler= (event) => {
        this.setState({value1: event.target.value});
    }
    changevalue2Handler= (event) => {
        this.setState({value2: event.target.value});
    }

    cancel(){
        this.props.history.push('/regularTimePoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RegularTimePoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> sequenceNumber: </label>
                                            #formFields( $attribute, 'update')
                                            <label> value1: </label>
                                            #formFields( $attribute, 'update')
                                            <label> value2: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRegularTimePoint}>Save</button>
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

export default UpdateRegularTimePointComponent
