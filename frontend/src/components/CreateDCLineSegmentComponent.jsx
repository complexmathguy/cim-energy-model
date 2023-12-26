import React, { Component } from 'react'
import DCLineSegmentService from '../services/DCLineSegmentService';

class CreateDCLineSegmentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                capacitance: '',
                inductance: '',
                length: '',
                resistance: ''
        }
        this.changecapacitanceHandler = this.changecapacitanceHandler.bind(this);
        this.changeinductanceHandler = this.changeinductanceHandler.bind(this);
        this.changelengthHandler = this.changelengthHandler.bind(this);
        this.changeresistanceHandler = this.changeresistanceHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
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
    }
    saveOrUpdateDCLineSegment = (e) => {
        e.preventDefault();
        let dCLineSegment = {
                dCLineSegmentId: this.state.id,
                capacitance: this.state.capacitance,
                inductance: this.state.inductance,
                length: this.state.length,
                resistance: this.state.resistance
            };
        console.log('dCLineSegment => ' + JSON.stringify(dCLineSegment));

        // step 5
        if(this.state.id === '_add'){
            dCLineSegment.dCLineSegmentId=''
            DCLineSegmentService.createDCLineSegment(dCLineSegment).then(res =>{
                this.props.history.push('/dCLineSegments');
            });
        }else{
            DCLineSegmentService.updateDCLineSegment(dCLineSegment).then( res => {
                this.props.history.push('/dCLineSegments');
            });
        }
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

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add DCLineSegment</h3>
        }else{
            return <h3 className="text-center">Update DCLineSegment</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> capacitance: </label>
                                            #formFields( $attribute, 'create')
                                            <label> inductance: </label>
                                            #formFields( $attribute, 'create')
                                            <label> length: </label>
                                            #formFields( $attribute, 'create')
                                            <label> resistance: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateDCLineSegment}>Save</button>
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

export default CreateDCLineSegmentComponent
