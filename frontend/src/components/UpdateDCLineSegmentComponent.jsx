import React, { Component } from 'react'
import DCLineSegmentService from '../services/DCLineSegmentService';

class UpdateDCLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                capacitance: '',
                inductance: '',
                length: '',
                resistance: ''
        }
        this.updateDCLineSegment = this.updateDCLineSegment.bind(this);

        this.changecapacitanceHandler = this.changecapacitanceHandler.bind(this);
        this.changeinductanceHandler = this.changeinductanceHandler.bind(this);
        this.changelengthHandler = this.changelengthHandler.bind(this);
        this.changeresistanceHandler = this.changeresistanceHandler.bind(this);
    }

    componentDidMount(){
        DCLineSegmentService.getDCLineSegmentById(this.state.id).then( (res) =>{
            let dCLineSegment = res.data;
            this.setState({
                capacitance: dCLineSegment.capacitance,
                inductance: dCLineSegment.inductance,
                length: dCLineSegment.length,
                resistance: dCLineSegment.resistance
            });
        });
    }

    updateDCLineSegment = (e) => {
        e.preventDefault();
        let dCLineSegment = {
            dCLineSegmentId: this.state.id,
            capacitance: this.state.capacitance,
            inductance: this.state.inductance,
            length: this.state.length,
            resistance: this.state.resistance
        };
        console.log('dCLineSegment => ' + JSON.stringify(dCLineSegment));
        console.log('id => ' + JSON.stringify(this.state.id));
        DCLineSegmentService.updateDCLineSegment(dCLineSegment).then( res => {
            this.props.history.push('/dCLineSegments');
        });
    }

    changecapacitanceHandler= (event) => {
        this.setState({capacitance: event.target.value});
    }
    changeinductanceHandler= (event) => {
        this.setState({inductance: event.target.value});
    }
    changelengthHandler= (event) => {
        this.setState({length: event.target.value});
    }
    changeresistanceHandler= (event) => {
        this.setState({resistance: event.target.value});
    }

    cancel(){
        this.props.history.push('/dCLineSegments');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DCLineSegment</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> capacitance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> inductance: </label>
                                            #formFields( $attribute, 'update')
                                            <label> length: </label>
                                            #formFields( $attribute, 'update')
                                            <label> resistance: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDCLineSegment}>Save</button>
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

export default UpdateDCLineSegmentComponent
