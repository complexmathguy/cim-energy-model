import React, { Component } from 'react'
import PhaseTapChangerTabularService from '../services/PhaseTapChangerTabularService';

class CreatePhaseTapChangerTabularComponent extends Component {
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
            PhaseTapChangerTabularService.getPhaseTapChangerTabularById(this.state.id).then( (res) =>{
                let phaseTapChangerTabular = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePhaseTapChangerTabular = (e) => {
        e.preventDefault();
        let phaseTapChangerTabular = {
                phaseTapChangerTabularId: this.state.id,
            };
        console.log('phaseTapChangerTabular => ' + JSON.stringify(phaseTapChangerTabular));

        // step 5
        if(this.state.id === '_add'){
            phaseTapChangerTabular.phaseTapChangerTabularId=''
            PhaseTapChangerTabularService.createPhaseTapChangerTabular(phaseTapChangerTabular).then(res =>{
                this.props.history.push('/phaseTapChangerTabulars');
            });
        }else{
            PhaseTapChangerTabularService.updatePhaseTapChangerTabular(phaseTapChangerTabular).then( res => {
                this.props.history.push('/phaseTapChangerTabulars');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/phaseTapChangerTabulars');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PhaseTapChangerTabular</h3>
        }else{
            return <h3 className="text-center">Update PhaseTapChangerTabular</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePhaseTapChangerTabular}>Save</button>
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

export default CreatePhaseTapChangerTabularComponent
