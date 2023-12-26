import React, { Component } from 'react'
import PhaseTapChangerSymmetricalService from '../services/PhaseTapChangerSymmetricalService';

class CreatePhaseTapChangerSymmetricalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
        }
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            PhaseTapChangerSymmetricalService.getPhaseTapChangerSymmetricalById(this.state.id).then( (res) =>{
                let phaseTapChangerSymmetrical = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePhaseTapChangerSymmetrical = (e) => {
        e.preventDefault();
        let phaseTapChangerSymmetrical = {
                phaseTapChangerSymmetricalId: this.state.id,
            };
        console.log('phaseTapChangerSymmetrical => ' + JSON.stringify(phaseTapChangerSymmetrical));

        // step 5
        if(this.state.id === '_add'){
            phaseTapChangerSymmetrical.phaseTapChangerSymmetricalId=''
            PhaseTapChangerSymmetricalService.createPhaseTapChangerSymmetrical(phaseTapChangerSymmetrical).then(res =>{
                this.props.history.push('/phaseTapChangerSymmetricals');
            });
        }else{
            PhaseTapChangerSymmetricalService.updatePhaseTapChangerSymmetrical(phaseTapChangerSymmetrical).then( res => {
                this.props.history.push('/phaseTapChangerSymmetricals');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/phaseTapChangerSymmetricals');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PhaseTapChangerSymmetrical</h3>
        }else{
            return <h3 className="text-center">Update PhaseTapChangerSymmetrical</h3>
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
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePhaseTapChangerSymmetrical}>Save</button>
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

export default CreatePhaseTapChangerSymmetricalComponent
