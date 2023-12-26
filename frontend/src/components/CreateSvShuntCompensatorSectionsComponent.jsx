import React, { Component } from 'react'
import SvShuntCompensatorSectionsService from '../services/SvShuntCompensatorSectionsService';

class CreateSvShuntCompensatorSectionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                sections: ''
        }
        this.changesectionsHandler = this.changesectionsHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            SvShuntCompensatorSectionsService.getSvShuntCompensatorSectionsById(this.state.id).then( (res) =>{
                let svShuntCompensatorSections = res.data;
                this.setState({
                    sections: svShuntCompensatorSections.sections
                });
            });
        }        
    }
    saveOrUpdateSvShuntCompensatorSections = (e) => {
        e.preventDefault();
        let svShuntCompensatorSections = {
                svShuntCompensatorSectionsId: this.state.id,
                sections: this.state.sections
            };
        console.log('svShuntCompensatorSections => ' + JSON.stringify(svShuntCompensatorSections));

        // step 5
        if(this.state.id === '_add'){
            svShuntCompensatorSections.svShuntCompensatorSectionsId=''
            SvShuntCompensatorSectionsService.createSvShuntCompensatorSections(svShuntCompensatorSections).then(res =>{
                this.props.history.push('/svShuntCompensatorSectionss');
            });
        }else{
            SvShuntCompensatorSectionsService.updateSvShuntCompensatorSections(svShuntCompensatorSections).then( res => {
                this.props.history.push('/svShuntCompensatorSectionss');
            });
        }
    }
    
    changesectionsHandler= (event) => {
        this.setState({sections: event.target.value});
    }

    cancel(){
        this.props.history.push('/svShuntCompensatorSectionss');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add SvShuntCompensatorSections</h3>
        }else{
            return <h3 className="text-center">Update SvShuntCompensatorSections</h3>
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
                                            <label> sections: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateSvShuntCompensatorSections}>Save</button>
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

export default CreateSvShuntCompensatorSectionsComponent
