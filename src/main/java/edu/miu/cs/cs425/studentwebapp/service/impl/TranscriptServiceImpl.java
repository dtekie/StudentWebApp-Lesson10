package edu.miu.cs.cs425.studentwebapp.service.impl;


import edu.miu.cs.cs425.studentwebapp.model.Transcript;
import edu.miu.cs.cs425.studentwebapp.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentwebapp.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {
    @Autowired
    private TranscriptRepository transcriptRepository;

    @Override
    public Transcript addNewTranscript(Transcript newTranscript) {
        return transcriptRepository.save(newTranscript);
    }
}
