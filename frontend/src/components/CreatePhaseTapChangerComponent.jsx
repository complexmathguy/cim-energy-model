import React, { Component } from 'react'
import PhaseTapChangerService from '../services/PhaseTapChangerService';

class CreatePhaseTapChangerComponent extends Component {
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
            PhaseTapChangerService.getPhaseTapChangerById(this.state.id).then( (res) =>{
                let phaseTapChanger = res.data;
                this.setState({
                });
            });
        }        
    }
    saveOrUpdatePhaseTapChanger = (e) => {
        e.preventDefault();
        let phaseTapChanger = {
                phaseTapChangerId: this.state.id,
            };
        console.log('phaseTapChanger => ' + JSON.stringify(phaseTapChanger));

        // step 5
        if(this.state.id === '_add'){
            phaseTapChanger.phaseTapChangerId=''
            PhaseTapChangerService.createPhaseTapChanger(phaseTapChanger).then(res =>{
                this.props.history.push('/phaseTapChangers');
            });
        }else{
            PhaseTapChangerService.updatePhaseTapChanger(phaseTapChanger).then( res => {
                this.props.history.push('/phaseTapChangers');
            });
        }
    }
    

    cancel(){
        this.props.history.push('/phaseTapChangers');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add PhaseTapChanger</h3>
        }else{
            return <h3 className="text-center">Update PhaseTapChanger</h3>
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

                                        <button className="btn btn-success" onClick={this.saveOrUpdatePhaseTapChanger}>Save</button>
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

export default CreatePhaseTapChangerComponent
