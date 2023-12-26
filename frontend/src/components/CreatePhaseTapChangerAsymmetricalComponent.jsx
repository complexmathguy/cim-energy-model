import React, { Component } from 'react'
import PhaseTapChangerAsymmetricalService from '../services/PhaseTapChangerAsymmetricalService';

class CreatePhaseTapChangerAsymmetricalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                windingConnectionAngle: ''
        }
        this.changewindingConnectionAngleHandler = this.changewindingConnectionAngleHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PhaseTapChangerAsymmetricalService.getPhaseTapChangerAsymmetricalById(this.state.id).then( (res) =>{
                let phaseTapChangerAsymmetrical = res.data;
                this.setState({
                    windingConnectionAngle: phaseTapChangerAsymmetrical.windingConnectionAngle
                });
            });
        }        
    }
    saveOrUpdatePhaseTapChangerAsymmetrical = (e) => {
        e.preventDefault();
        let phaseTapChangerAsymmetrical = {
                phaseTapChangerAsymmetricalId: this.state.id,
                windingConnectionAngle: this.state.windingConnectionAngle
            };
        console.log('phaseTapChangerAsymmetrical => ' + JSON.stringify(phaseTapChangerAsymmetrical));

        // step 5
        if(this.state.id === '_add'){
            phaseTapChangerAsymmetrical.phaseTapChangerAsymmetricalId=''
            PhaseTapChangerAsymmetricalService.createPhaseTapChangerAsymmetrical(phaseTapChangerAsymmetrical).then(res =>{
                this.props.history.push('/phaseTapChangerAsymmetricals');
            });
        }else{
            PhaseTapChangerAsymmetricalService.updatePhaseTapChangerAsymmetrical(phaseTapChangerAsymmetrical).then( res => {
                this.props.history.push('/phaseTapChangerAsymmetricals');
            });
        }
    }
    
    changewindingConnectionAngleHandler= (event) => {
        this.setState({windingConnectionAngle: event.target.value});
    }

    cancel(){
        this.props.history.push('/phaseTapChangerAsymmetricals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PhaseTapChangerAsymmetrical</h3>
        }else{
            return <h3 className="text-center">Update PhaseTapChangerAsymmetrical</h3>
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
                                            <label> windingConnectionAngle: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePhaseTapChangerAsymmetrical}>Save</button>
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

export default CreatePhaseTapChangerAsymmetricalComponent
