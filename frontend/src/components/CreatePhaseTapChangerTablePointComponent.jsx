import React, { Component } from 'react'
import PhaseTapChangerTablePointService from '../services/PhaseTapChangerTablePointService';

class CreatePhaseTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                angle: ''
        }
        this.changeangleHandler = this.changeangleHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PhaseTapChangerTablePointService.getPhaseTapChangerTablePointById(this.state.id).then( (res) =>{
                let phaseTapChangerTablePoint = res.data;
                this.setState({
                    angle: phaseTapChangerTablePoint.angle
                });
            });
        }        
    }
    saveOrUpdatePhaseTapChangerTablePoint = (e) => {
        e.preventDefault();
        let phaseTapChangerTablePoint = {
                phaseTapChangerTablePointId: this.state.id,
                angle: this.state.angle
            };
        console.log('phaseTapChangerTablePoint => ' + JSON.stringify(phaseTapChangerTablePoint));

        // step 5
        if(this.state.id === '_add'){
            phaseTapChangerTablePoint.phaseTapChangerTablePointId=''
            PhaseTapChangerTablePointService.createPhaseTapChangerTablePoint(phaseTapChangerTablePoint).then(res =>{
                this.props.history.push('/phaseTapChangerTablePoints');
            });
        }else{
            PhaseTapChangerTablePointService.updatePhaseTapChangerTablePoint(phaseTapChangerTablePoint).then( res => {
                this.props.history.push('/phaseTapChangerTablePoints');
            });
        }
    }
    
    changeangleHandler= (event) => {
        this.setState({angle: event.target.value});
    }

    cancel(){
        this.props.history.push('/phaseTapChangerTablePoints');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PhaseTapChangerTablePoint</h3>
        }else{
            return <h3 className="text-center">Update PhaseTapChangerTablePoint</h3>
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
                                            <label> angle: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePhaseTapChangerTablePoint}>Save</button>
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

export default CreatePhaseTapChangerTablePointComponent
